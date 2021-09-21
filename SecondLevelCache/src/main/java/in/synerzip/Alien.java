package in.synerzip;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Alien_TBL")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	
	@Id
	private Integer aId;
	
	private AlienName alienName;
	
	public AlienName getAlienName() {
		return alienName;
	}
	public void setAlienName(AlienName alienName) {
		this.alienName = alienName;
	}
	private String aColor;
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	
	public String getaColor() {
		return aColor;
	}
	public void setaColor(String aColor) {
		this.aColor = aColor;
	}
	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", alienName=" + alienName + ", aColor=" + aColor + "]";
	}


}
