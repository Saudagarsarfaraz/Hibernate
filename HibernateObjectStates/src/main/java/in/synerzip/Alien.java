package in.synerzip;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Alien_NEW")
public class Alien {
	
	@Id
	private Integer aId;
	private String aName;
	private String aColor;
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaColor() {
		return aColor;
	}
	public void setaColor(String aColor) {
		this.aColor = aColor;
	}
	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", aName=" + aName + ", aColor=" + aColor + "]";
	}

}
