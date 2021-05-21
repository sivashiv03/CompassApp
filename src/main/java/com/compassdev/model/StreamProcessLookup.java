package com.compassdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stream_process_lookup")
public class StreamProcessLookup {

	@Id
	@Column(name = "process_id")
	private Integer processId;
	
	@Column(name = "stream_code")
	private String streamCode;
	
	@Column(name = "process_name")
	private String processName;
	/**
	 * @return the streamCode
	 */
	public String getStreamCode() {
		return streamCode;
	}
	/**
	 * @param streamCode the streamCode to set
	 */
	public void setStreamCode(String streamCode) {
		this.streamCode = streamCode;
	}
	/**
	 * @return the processName
	 */
	public String getProcessName() {
		return processName;
	}
	/**
	 * @param processName the processName to set
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	/**
	 * @return the processId
	 */
	public Integer getProcessId() {
		return processId;
	}
	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	
	
	
	
	
}
