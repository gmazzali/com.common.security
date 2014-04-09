package com.common.security.domain.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Session generated by hbm2java
 */
public class Session extends PersistentObject {
	private static final long serialVersionUID = 4965689954593899700L;

	public Session() {
		super();
		this.sessionInitDate = new Timestamp(new Date().getTime());
		this.logs = new HashSet<Log>();
	}

	public Session(Participation part) {
		this();
		this.participation = part;
	}

	private Date sessionInitDate;

	private Date sessionEndDate;

	private String sessionEndMotive;

	private String observations;

	private Participation participation;

	private Integer idSystem;

	/**
	 * @directed
	 * @link aggregation
	 * @associates Log
	 */
	private Set<Log> logs;

	public Set<Log> getLogs() {
		return logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Date getSessionEndDate() {
		return sessionEndDate;
	}

	public void setSessionEndDate(Date sessionEndDate) {
		this.sessionEndDate = sessionEndDate;
	}

	public String getSessionEndMotive() {
		return sessionEndMotive;
	}

	public void setSessionEndMotive(String sessionEndMotive) {
		this.sessionEndMotive = sessionEndMotive;
	}

	public Date getSessionInitDate() {
		return sessionInitDate;
	}

	public void setSessionInitDate(Date sessionInitDate) {
		this.sessionInitDate = sessionInitDate;
	}

	public Participation getParticipation() {
		return participation;
	}

	public void setParticipation(Participation participation) {
		this.participation = participation;
	}

	public Integer getIdSystem() {
		return idSystem;
	}

	public void setIdSystem(Integer idSystem) {
		this.idSystem = idSystem;
	}

	public void addLog(Log log) {
		log.setSession(this);
		getLogs().add(log);
	}

}