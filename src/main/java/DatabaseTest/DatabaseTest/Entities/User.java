package DatabaseTest.DatabaseTest.Entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name="USER_ID")
    private String user_id;
	
	@Column(name="BANK_ID")
    private String bank_id;
	
	@Column(name="BRANCH_ID")
    private String branch_id;
	
	@Column(name="CITY_ID")
    private String city_id;
	
	@Column(name="INSERTED_BY")
    private String inserted_by;
	
	@Column(name="INSERTED_DATE")
    private Date inserted_date;
	
	@Column(name="LOGON_RETRY")
    private String logon_retry;
	
	@Column(name="MAX_LOGON_RETRY")
    private String max_logon_retry;
	
	@Column(name="NAME_SURNAME")
    private String name_surname;
	
	@Column(name="USER_PASSWORD")
    private String user_password;
	
	@Column(name="PWD_EXPIRATION_DATE")
    private Date pwd_expiration_date;
	
	@Column(name="TELLER_ID")
    private String teller_id;
	
	@Column(name="UPDATED_BY")
    private String updated_by;
	
	@Column(name="UPDATED_DATE")
    private Date updated_date;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getInserted_by() {
		return inserted_by;
	}

	public void setInserted_by(String inserted_by) {
		this.inserted_by = inserted_by;
	}

	public Date getInserted_date() {
		return inserted_date;
	}

	public void setInserted_date(Date inserted_date) {
		this.inserted_date = inserted_date;
	}

	public String getLogon_retry() {
		return logon_retry;
	}

	public void setLogon_retry(String logon_retry) {
		this.logon_retry = logon_retry;
	}

	public String getMax_logon_retry() {
		return max_logon_retry;
	}

	public void setMax_logon_retry(String max_logon_retry) {
		this.max_logon_retry = max_logon_retry;
	}

	public String getName_surname() {
		return name_surname;
	}

	public void setName_surname(String name_surname) {
		this.name_surname = name_surname;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Date getPwd_expiration_date() {
		return pwd_expiration_date;
	}

	public void setPwd_expiration_date(Date pwd_expiration_date) {
		this.pwd_expiration_date = pwd_expiration_date;
	}

	public String getTeller_id() {
		return teller_id;
	}

	public void setTeller_id(String teller_id) {
		this.teller_id = teller_id;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

}
