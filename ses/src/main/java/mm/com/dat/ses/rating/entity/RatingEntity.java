/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	18/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.rating.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rating")
public class RatingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long rating_id;
	
	@Column(name="rating_rate",nullable=false)
	private String ratingRate;
	
	@Column(name="rating_detail")
	private String ratingDetail;
	
	@Column(name = "del_flag", nullable = false)
	private Short delFlag;

	@Column(name = "created_by",nullable = false)
	private Long createdBy;
	
	@Column(name = "created_time", nullable = false)
	private Timestamp createdTime;
	
	@Column(name = "updated_by")
	private Long updatedBy;
	
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
}
