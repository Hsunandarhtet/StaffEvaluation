/***************************************************************
 * Author       :							
 * Created Date :
 * Updated Date :
 * Version      : 
 * Dev History  :
***************************************************************/

package mm.com.dat.ses.probation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;
import mm.com.dat.ses.user.entity.UserEntity;

@Data
@Entity
@Table(name = "probation")
public class ProbationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long probation_id;
	
	@Column(name = "probation_no", length = 8, nullable = false)
	private String probationNo;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private UserEntity userId;
	
	@Column(name = "probation_start_date",nullable = false)
	private Date probationStartDate;
	
	@Column(name = "probation_end_date", nullable = false)
	private Date probationEndDat123;
		
}
