package mm.com.dat.ses.evaluation.item.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;
import mm.com.dat.ses.evaluation.category.entity.EvalCategoryEntity;

@Data
@Entity
@Table(name = "eval_item")
public class EvalItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long eval_item_id;
	
	@ManyToOne
	@JoinColumn(name="eval_category_id",nullable=false)
	private EvalCategoryEntity evalCategoryId;
	
	@Column(name="eval_item_name",nullable=false)
	private String evalItemName;
	
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
