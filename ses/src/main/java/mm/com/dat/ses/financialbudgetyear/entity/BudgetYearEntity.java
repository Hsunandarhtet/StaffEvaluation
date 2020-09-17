package mm.com.dat.ses.financialbudgetyear.entity;

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
@Table(name="budget_year")
public class BudgetYearEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OrderBy
	private long budget_year_id;
	
	@Column(name="budget_year",nullable=false,length=9,unique=true)
	private String budgetYear;
	
	@Column(name="from_month",nullable=false,length=5)
	private String fromMonth;
	
	@Column(name="to_month",nullable=false,length=5)
	private String toMonth;
	
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
