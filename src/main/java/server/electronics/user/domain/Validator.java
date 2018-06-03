package server.electronics.user.domain;

interface Validator<T> {
    boolean usernameExists(T t);
    boolean emailExists(T t);
}
