package kz.baibalaeva.demo.trelloServices.trelloImpl;

import kz.baibalaeva.demo.trelloModels.Folders;
import kz.baibalaeva.demo.trelloRepositories.FoldersRepository;
import kz.baibalaeva.demo.trelloServices.FoldersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoldersImpl implements FoldersServices {

    @Autowired
    private FoldersRepository foldersRepository;

    @Override
    public Folders addFolders(Folders folders) {
        return foldersRepository.save(folders);
    }

    @Override
    public Folders saveFolders(Folders folders) {
        return foldersRepository.save(folders);
    }

    @Override
    public List<Folders> getAllFolders() {
        return foldersRepository.findAll();
    }

    @Override
    public Folders getFolders(Long id) {
        return foldersRepository.getOne(id);
    }

    @Override
    public void deleteFolders(Folders folders) {
    foldersRepository.delete(folders);
    }
}
