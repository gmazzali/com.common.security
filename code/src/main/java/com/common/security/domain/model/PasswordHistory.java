package com.common.security.domain.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.common.util.business.tool.DateUtil;
import com.common.util.business.tool.StringUtil;
import com.common.util.domain.model.entity.Entity;

/**
 * El historial de cambios de password de un usuario.
 * 
 * @since 10/03/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@Table(name = "SECURITY_PASSWORDS_HISTORIES")
@javax.persistence.Entity(name = "PasswordHistory")
public class PasswordHistory extends Entity<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Entity.Attributes
	 */
	public interface Attributes extends Entity.Attributes {
		public static final String USER = "user";
		public static final String ENCODE_PASSWORD = "encodedPassword";
		public static final String CHANGE_DATE = "changeDate";
	}

	/**
	 * El usuario al que corresponde esta historia.
	 */
	private User user;
	/**
	 * La password que acabamos de asignarle al usuario.
	 */
	private String encodePassword;
	/**
	 * La fecha de cambio de la password.
	 */
	private Date changeDate;

	/**
	 * El contructor de una historia de cambio de password de un usuario.
	 */
	public PasswordHistory() {
		super();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(StringUtil.toString(this.user));
		buffer.append(" ");
		buffer.append(DateUtil.formatDate(this.changeDate));
		buffer.append(" ");
		buffer.append(this.encodePassword);
		return buffer.toString();
	}

	@Id
	@Override
	@Column(name = "ID_SECURITY_PASSWORD_HISTORY", columnDefinition = "integer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/**
	 * Retorna el usuario que corresponde a esta entrada de historial.
	 * 
	 * @return El usuario de esta entrada de historial.
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER", nullable = false)
	public User getUser() {
		return user;
	}

	/**
	 * Carga el usuario que corresponde a esta entrada de historial.
	 * 
	 * @param user
	 *            El usuario de esta entrada de historial.
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Retorna la password codificada que fue cambiada.
	 * 
	 * @return La password codificada que fue cambiada.
	 */
	@Column(name = "PASSWORD", columnDefinition = "text", nullable = false)
	public String getEncodePassword() {
		return encodePassword;
	}

	/**
	 * Carga la password codificada que fue cambiada.
	 * 
	 * @param encodePassword
	 *            La password codificada que fue cambiada.
	 */
	public void setEncodePassword(String encodePassword) {
		this.encodePassword = encodePassword;
	}

	/**
	 * Retorna la fecha en la que se realiz� el cambio de password al usuario.
	 * 
	 * @return La fecha en la que se realiz� el cambio de password.
	 */
	@Column(name = "CHANGE_DATE", columnDefinition = "timestamp", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getChangeDate() {
		return changeDate;
	}

	/**
	 * Carga la fecha en la que se realiz� el cambio de password al usuario.
	 * 
	 * @param changeDate
	 *            La fecha en la que se realiz� el cambio de password.
	 */
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
}