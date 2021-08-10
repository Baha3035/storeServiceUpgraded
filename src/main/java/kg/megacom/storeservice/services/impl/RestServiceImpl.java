package kg.megacom.storeservice.services.impl;

import kg.megacom.storeservice.dao.RestRepo;
import kg.megacom.storeservice.models.dtos.RestDto;
import kg.megacom.storeservice.services.RestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RestServiceImpl implements RestService {
    private RestRepo restRepo;
    @Override
    public RestDto save(RestDto restDto) {
        return null;
    }

    @Override
    public RestDto update(RestDto restDto) {
        return null;
    }

    @Override
    public RestDto findById(Long id) {
        return null;
    }

    @Override
    public List<RestDto> findAll() {
        return null;
    }
}
