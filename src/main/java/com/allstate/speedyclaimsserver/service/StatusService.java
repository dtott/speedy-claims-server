package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Statuses;

public interface StatusService {

    public Statuses findStatusById(Integer id);

}
