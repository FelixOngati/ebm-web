/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebm.web.model.persistence;


import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author the_fegati
 */
@Entity
@Table(name = "tblAssociationRules")

public class TblAssociationRules implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ruleId", nullable = false)
    private Integer ruleId;

    @Basic(optional = false)
    @Lob
    @Column(name = "rule", nullable = false, length = 65535)
    private String rule;

    @Basic(optional = false)
    @Column(name = "confidence", nullable = false)
    private float confidence;

    @Basic(optional = false)
    @Column(name = "support", nullable = false)
    private float support;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating", precision = 2)
    private Float rating;

    public TblAssociationRules() {
    }

    public TblAssociationRules(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public TblAssociationRules(Integer ruleId, String rule, float confidence, float support) {
        this.ruleId = ruleId;
        this.rule = rule;
        this.confidence = confidence;
        this.support = support;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public float getSupport() {
        return support;
    }

    public void setSupport(float support) {
        this.support = support;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleId != null ? ruleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAssociationRules)) {
            return false;
        }
        TblAssociationRules other = (TblAssociationRules) object;
        if ((this.ruleId == null && other.ruleId != null) || (this.ruleId != null && !this.ruleId.equals(other.ruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.persistence.TblAssociationRules[ ruleId=" + ruleId + " ]";
    }

}