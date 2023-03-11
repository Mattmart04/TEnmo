package com.techelevator.dao;

import com.techelevator.tenmo.controller.AuthenticationController;
import com.techelevator.tenmo.dao.AccountRepository;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.RegisterUserDto;
import com.techelevator.tenmo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/*
@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthenticationControllerTests extends BaseDaoTests {
    protected static final User USER_1 = new User(1001, "user1", "user1", "USER");
    protected static final User USER_2 = new User(1002, "user2", "user2", "USER");
    private static final User USER_3 = new User(1003, "user3", "user3", "USER");

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserDao sut;

    @Test(expected = IllegalArgumentException.class)
    public void findIdByUsername_given_null_throws_exception() {
        sut.findIdByUsername(null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void findIdByUsername_given_invalid_username_throws_exception() {
        sut.findIdByUsername("invalid");
    }

    @Test
    public void findIdByUsername_given_valid_user_returns_user_id() {
        int actualUserId = sut.findIdByUsername(USER_1.getUsername());

        Assert.assertEquals(USER_1.getId(), actualUserId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByUsername_given_null_throws_exception() {
        sut.findByUsername(null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void findByUsername_given_invalid_username_throws_exception() {
        sut.findByUsername("invalid");
    }

    @Test
    public void findByUsername_given_valid_user_returns_user() {
        User actualUser = sut.findByUsername(USER_1.getUsername());

        Assert.assertEquals(USER_1, actualUser);
    }

    @Test
    public void getUserById_given_invalid_user_id_returns_null() {
        User actualUser = sut.findByUserId(-1);

        Assert.assertNull(actualUser);
    }

    @Test
    public void getUserById_given_valid_user_id_returns_user() {
        User actualUser = sut.findByUserId(USER_1.getUserId());

        Assert.assertEquals(USER_1, actualUser);
    }

    @Test
    public void findAll_returns_all_users() {
        List<User> users = sut.findAll();

        Assert.assertNotNull(users);
        Assert.assertEquals(3, users.size());
        Assert.assertEquals(USER_1, users.get(0));
        Assert.assertEquals(USER_2, users.get(1));
        Assert.assertEquals(USER_3, users.get(2));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_user_with_null_username() {
        User user = new User(null, USER_1.getPassword());
        sut.save(user);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void create_user_with_existing_username() {
        User user = new User(USER_1.getUsername(), USER_3.getPassword());
        sut.save(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_user_with_null_password() {
        User user = new User(USER_1.getUsername(), null);
        sut.save(user);
    }

    @Test
    public void create_user_creates_a_user() {
        User newUser = new User(-1, "new", "user", "USER");

        User userWasCreated = sut.save(newUser);

        Assert.assertNotNull(userWasCreated);

        User actualUser = sut.findByUsername(newUser.getUsername());
        newUser.setId(actualUser.getId());

        actualUser.setPassword(newUser.getPassword()); // reset password back to unhashed password for testing
        Assert.assertEquals(newUser, actualUser);
    }

}
*/