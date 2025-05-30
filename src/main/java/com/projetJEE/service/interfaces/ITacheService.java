package com.projetJEE.Services;

import com.projetJEE.model.Tache;

import java.util.List;

public interface ITacheService {
    public Tache saveT(Tache tache);
    public Tache updateTask(Tache tache, Integer id);
    public void deleteTaskById(Integer id);
    public Tache getTaskById(Integer id);
    public void deleteTask(Tache tache);
    public List<Tache> fetchTaskList();
}
