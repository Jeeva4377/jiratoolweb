package pojo;

public class Jira {

	int id;
	String Assignee;
	String reporter;
	String head;
	String status;
	String notify;
	
	public Jira() {
		super();
	}
	public Jira(int id, String assignee, String reporter, String head, String status, String notify) {
		super();
		this.id = id;
		Assignee = assignee;
		this.reporter = reporter;
		this.head = head;
		this.status = status;
		this.notify = notify;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAssignee() {
		return Assignee;
	}
	public void setAssignee(String assignee) {
		Assignee = assignee;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNotify() {
		return notify;
	}
	public void setNotify(String notify) {
		this.notify = notify;
	}
	
	
}
