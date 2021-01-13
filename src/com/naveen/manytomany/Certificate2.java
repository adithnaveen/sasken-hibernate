package com.naveen.manytomany;

import java.util.HashSet;
import java.util.Set;

public class Certificate2 {
	private int certificateId;
	private String certificateName;
	private Set<Employee2> employees = new HashSet<Employee2>();

	public Certificate2(String certificateName) {
		this.certificateName = certificateName;
	}

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;

		Certificate2 cert = (Certificate2) obj;
		if ((this.certificateId == cert.getCertificateId())
				&& (this.certificateName.equals(cert.getCertificateName())))
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		return (certificateId + certificateName).hashCode();
	}

	public Set<Employee2> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee2> employees) {
		this.employees = employees;
	}

}
