package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerCSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile) throws FileNotFoundException;
}