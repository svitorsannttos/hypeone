package com.example.hypeadvice.domain.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.example.hypeadvice.domain.vo.AdviceVO;
import com.example.hypeadvice.domain.vo.Slip;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.hypeadvice.domain.entity.Advice;
import com.example.hypeadvice.domain.service.AdviceService;
import com.example.hypeadvice.domain.vo.AdviceListVO;

import java.util.List;
import java.util.Objects;

@Named
@ViewScoped
public class AdviceListBean extends Bean {

	@Autowired AdviceService adviceService;
    private Advice advice = new Advice();
    private AdviceListVO adviceListVO;
    private AdviceVO adviceVO;

    public void initBean() {
        advice = new Advice();
    }

    public void buscar() {
        try {
            this.adviceListVO = adviceService.buscar(advice);
            this.adviceVO = null;
        } catch (Exception e) {
            addMessageError(e);
        }
    }

    public void buscarId() {
        try {
            this.adviceVO = adviceService.buscarId(advice.getId());
            this.adviceListVO = null;
            if(Objects.nonNull(adviceVO)){addFaceMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", null);}
        } catch (Exception e) {
            addMessageError(e);
        }
    }

    public AdviceListVO getAdviceListVO() {
        return adviceListVO;
    }

    public AdviceVO getAdviceVO(){
        return adviceVO;
    }

    public List<Slip> get(){
        if (Objects.nonNull(adviceListVO)){
            return adviceListVO.getSlips();
        } else if (Objects.nonNull(adviceVO)) {
            return adviceVO.getSlips();
        }
        return null;
    }

    public void setAdviceVO(AdviceVO adviceVO) {
        this.adviceVO = adviceVO;
    }

    public void setAdviceListVO(AdviceListVO adviceListVO) {
        this.adviceListVO = adviceListVO;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

}
