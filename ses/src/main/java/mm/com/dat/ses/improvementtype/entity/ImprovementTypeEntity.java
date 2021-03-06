/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	18/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.improvementtype.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name = "improvement_type")
@Where(clause = "del_flag=0")
public class ImprovementTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private Long improvement_type_id;

	@Column(name = "improvement_type", nullable = false)
	private String improvementType;

	@Column(name = "del_flag", nullable = false)
	private Short delFlag;

	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	@Column(name = "created_time", nullable = false)
	private Timestamp createdTime;

	@Column(name = "updated_by")
	private Long updatedBy;

	@Column(name = "updated_time")
	private Timestamp updatedTime;
}
