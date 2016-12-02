package de.assertagile.workshop.spocktesting;

interface UserRepository {

    void saveUser(final UserEntity user);

    UserEntity findUserByUserName(final String userName);
}
