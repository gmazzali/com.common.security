package com.common.security.persistence.dao;

import com.common.security.domain.model.User;

/**
 * La interfaz del DAO para los usuarios.
 * 
 * @since 07/04/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
public interface UserDao extends SecurityBaseDao<User, Long> {
}