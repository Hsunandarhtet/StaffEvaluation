package mm.com.dat.ses.evaluation.category.entity;

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
@Table(name="eval_category")
public class EvalCategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long eval_category_id;
	
	@Column(name="eval_category_name",nullable=false)
	private String evalCategoryName;
	
	@Column(name = "deg_flag", nullable = false)
	private Short degFlag;

	@Column(name = "created_by", nullable = false,length = 8)
	private String createdBy;
	
	@Column(name = "created_time", nullable = false)
	private Timestamp createdTime;

	@Column(name = "updated_by",length = 8)
	private String updatedBy;
	
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
}