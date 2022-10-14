package com.javarush.services;

import com.javarush.dao.AutoDao;
import com.javarush.models.Auto;

import java.util.List;

public class AutoService {

    private AutoDao autosDao = new AutoDao();

    public AutoService() {
    }

    public Auto findAuto(int id) {
        return autosDao.findById(id);
    }

    public void saveAuto(Auto auto) {
        autosDao.save(auto);
    }

    public void deleteAuto(Auto auto) {
        autosDao.delete(auto);
    }

    public void updateAuto(Auto auto) {
        autosDao.update(auto);
    }

    public List<Auto> findAllAutos() {
        return autosDao.findAll();
    }

    public Auto findAutoById(int id) {
        return autosDao.findAutoById(id);
    }

}