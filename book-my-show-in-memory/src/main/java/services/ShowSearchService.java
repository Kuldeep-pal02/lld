package services;

import lombok.Data;
import model.Show;
import model.repository.IDatabaseRepository;
import model.repository.ShowRepo;

import java.util.List;
import java.util.function.Predicate;

@Data
public class ShowSearchService {

    private final IDatabaseRepository<Show, Integer> showRepo;

    public ShowSearchService(  IDatabaseRepository<Show, Integer> showRepo){
        this.showRepo = showRepo;
    }

    public List<Show> findAllShowsByTheaterId( int theaterId){
        Predicate<Show> predicate = show -> show.getTheaterId() == theaterId;
        return  showRepo.findByCondition( predicate );
    }






}
