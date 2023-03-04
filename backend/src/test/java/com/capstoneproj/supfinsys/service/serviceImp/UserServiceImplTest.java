package com.capstoneproj.supfinsys.service.serviceImp;

import com.capstoneproj.supfinsys.exception.UsernameNotFoundException;
import com.capstoneproj.supfinsys.models.User;
import com.capstoneproj.supfinsys.repository.UserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testGetClientByUsername() throws UsernameNotFoundException {
        User user = new User();
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.of(user));
        assertSame(user, userServiceImpl.getClientByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
    }

    @Test
    void testGetClientByUsername2() throws UsernameNotFoundException {
        when(userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.getClientByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
    }

    @Test
    void testGetClientByUsername3() throws UsernameNotFoundException {
        when(userRepository.findByUsername((String) any())).thenThrow(new UsernameNotFoundException("An error occurred"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.getClientByUsername("janedoe"));
        verify(userRepository).findByUsername((String) any());
    }

    @Test
    void testClientUsernameExists() {
        when(userRepository.existsByUsername((String) any())).thenReturn(true);
        assertTrue(userServiceImpl.clientUsernameExists("username"));
        verify(userRepository).existsByUsername((String) any());
    }

    @Test
    void testClientUsernameExists2() {
        when(userRepository.existsByUsername((String) any())).thenReturn(false);
        assertFalse(userServiceImpl.clientUsernameExists("janedoe"));
        verify(userRepository).existsByUsername((String) any());
    }


    @Test
    void testClientUsernameExists3() {
        when(userRepository.existsByUsername((String) any()))
                .thenThrow(new UsernameNotFoundException("An error occurred"));
        assertThrows(UsernameNotFoundException.class, () -> userServiceImpl.clientUsernameExists("janedoe"));
        verify(userRepository).existsByUsername((String) any());
    }

}