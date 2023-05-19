package com.GestionEquipe.GestionEquipe.Controller;

import com.GestionEquipe.GestionEquipe.Services.IRapportService;
import com.GestionEquipe.GestionEquipe.model.Rapport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rapport")
public class RapportController {

    @Autowired
    private IRapportService iRapportService;
    @PostMapping("/save")
    public Rapport SaveRapport(@RequestBody Rapport rapport){
        Rapport rapportToReturn = iRapportService.saveRap(rapport);
        return rapportToReturn;
    }
    @PutMapping("/update/{id}")
    public Rapport updateRapport(@RequestBody Rapport rapport,
                                         @PathVariable("id") Integer id)
    {
        return iRapportService.updateRap(rapport,id);
    }

    // Read raw by id

    @GetMapping("/getAll")

    public List<Rapport> getRapportList()
    {
        return iRapportService.fetchRapList();
    }

    // Read All Raws
    @GetMapping("/getByid/{id}")

    public Rapport getRapportById(@PathVariable("id")
                                      Integer id)
    {
        return iRapportService.getRapById(id);

    }
    // Delete raw by id
    @DeleteMapping("/delByid/{id}")

    public String deleteRapportById(@PathVariable("id")
                                        Integer id)
    {
        iRapportService.deleteRapById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/deleteAll")
    public String deleteRapport(Rapport rapport)
    {
        iRapportService.deleteRap(rapport);
        return "Deleted Successfully";
    }


    @GetMapping("/api/download")
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        File file = new File("path/to/file.pdf");
        InputStream inputStream = new FileInputStream(file);

        byte[] fileContent = new byte[(int) file.length()];
        inputStream.read(fileContent);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "file.pdf");

        return ResponseEntity.ok().headers(headers).body(fileContent);
    }
}


