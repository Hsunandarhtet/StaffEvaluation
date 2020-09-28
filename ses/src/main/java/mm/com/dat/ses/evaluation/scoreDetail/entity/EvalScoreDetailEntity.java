/***************************************************************
 * Author       :	Hsu Nandar Htet						
 * Created Date :	18/9/2020
 * Updated Date :	-
 * Version      : 	1.0
 * Dev History  :	-
***************************************************************/

package mm.com.dat.ses.evaluation.scoreDetail.entity;

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
import mm.com.dat.ses.evaluation.item.entity.EvalItemEntity;
import mm.com.dat.ses.evaluation.scoreHead.entity.EvalScoreHeadEntity;

@Data
@Entity
@Table(name = "eval_score_detail")
public class EvalScoreDetailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long eval_detail_id;
	
	@ManyToOne
	@JoinColumn(name="eval_score_head_id",nullable=false)
	private EvalScoreHeadEntity evalScoreHeadId;
	
	@ManyToOne
	@JoinColumn(name="eval_item_id")
	private EvalItemEntity evalItemId;
	
	@ManyToOne
	@JoinColumn(name="eval_category_id")
	private EvalCategoryEntity evalCategoryId;
	
	@Column(name="score_record_type",nullable=false,length=3)
	private String scoreRecordType;
	
	@Column(name="first_month_score")
	private int firstMonthScore;
	
	@Column(name="second_month_score")
	private int secondMonthScore;
	
	@Column(name="third_month_score")
	private int thirdMonthScore;
	
	@Column(name="fourth_month_score")
	private int fourthMonthScore;
	
	@Column(name="fifth_month_score")
	private int fifthMonthScore;
	
	@Column(name="sixth_month_score")
	private int sixthMonthScore;
	
	@Column(name="seventh_month_score")
	private int seventhMonthScore;
	
	@Column(name="eighth_month_score")
	private int eighthMonthScore;
	
	@Column(name="ninth_month_score")
	private int ninthMonthScore;
	
	@Column(name="tenth_month_score")
	private int tenthMonthScore;
	
	@Column(name="eleventh_month_score")
	private int eleventhMonthScore;
	
	@Column(name="twelfth_month_score")
	private int twelfthMonthScore;
	
}
