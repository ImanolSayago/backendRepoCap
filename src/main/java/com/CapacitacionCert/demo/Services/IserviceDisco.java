package com.CapacitacionCert.demo.Services;

import com.CapacitacionCert.demo.DTO.DiscoDTO;
import com.CapacitacionCert.demo.Model.Disco;

import java.util.List;

public interface IserviceDisco {

    public List<Disco> getDisco();

    public Disco getDiscoById(Long id);

    public Boolean addDisco(DiscoDTO disco);

    public Boolean deleteDiscoById(Long id);

    public Boolean editDisco(Long id,DiscoDTO disco);

}
