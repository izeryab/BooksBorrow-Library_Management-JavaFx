import java.io.Serializable;
/**
 * IssueBooks Class Design to Handle IssueBooks data
 * */
public class IssueBooks implements Serializable {
	//Serial ID for filing
	private static final long serialVersionUID = 1L;
	//Data Members
	private int issue;
	private int Sid;
	private String sname;
	private String bid;
	private String bname;
	
	//Constructor
	public IssueBooks(int studentid, String sname, String bid, String bname) {
	
		this.issue = studentid+Integer.parseUnsignedInt(bid);
		this.Sid = studentid;
		this.sname = sname;
		this.bid = bid;
		this.bname = bname;
	}
	//constructor
	public IssueBooks(){}
	
	/**
	 * Getter and Setter for Data Members
	 * */
	public int getIssue() {
		return issue;
	}
	public void setIssue(int id) {
		this.issue = id;
	}
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		this.Sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	@Override
	public String toString() {
		return "IssueBooks [id=" + issue + ", sid=" + Sid + ", sname=" + sname + ", bid=" + bid + ", bname=" + bname + "]";
	}
	
	
}
