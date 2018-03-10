package infomanagers;

public class CpuInfo {
	private int id;
	private double userUseRate;
	private double sysUseRate;
	private double waitRate;
	private double errorRate;
	private double idleRate;
	private double totalUserate;
	
	public double getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getUserUseRate() {
		return userUseRate;
	}
	public void setUserUseRate(double userUseRate) {
		this.userUseRate = userUseRate;
	}
	public double getSysUseRate() {
		return sysUseRate;
	}
	public void setSysUseRate(double sysUseRate) {
		this.sysUseRate = sysUseRate;
	}
	public double getWaitRate() {
		return waitRate;
	}
	public void setWaitRate(double waitRate) {
		this.waitRate = waitRate;
	}
	public double getErrorRate() {
		return errorRate;
	}
	public void setErrorRate(double errorRate) {
		this.errorRate = errorRate;
	}
	public double getIdleRate() {
		return idleRate;
	}
	public void setIdleRate(double idleRate) {
		this.idleRate = idleRate;
	}
	public double getTotalUserate() {
		return totalUserate;
	}
	public void setTotalUserate(double totalUserate) {
		this.totalUserate = totalUserate;
	}
	@Override
	public String toString() {
		return "CpuInfo [id=" + id + ", userUseRate=" + userUseRate
				+ ", sysUseRate=" + sysUseRate + ", waitRate=" + waitRate
				+ ", errorRate=" + errorRate + ", idleRate=" + idleRate
				+ ", totalUserate=" + totalUserate + "]";
	}

	
	

	
	
}
