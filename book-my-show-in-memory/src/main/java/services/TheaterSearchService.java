package services;

import model.Theater;
import model.repository.IDatabaseRepository;
import model.repository.TheaterRepo;

import java.util.List;

public class TheaterSearchService {
    final private IDatabaseRepository<Theater, Integer> theaterRepo;
    public TheaterSearchService(TheaterRepo theaterRepo) {
        this.theaterRepo = theaterRepo;
    }

    public List<Theater> getAllTheaters(){
        return theaterRepo.findAll();
    }


}
