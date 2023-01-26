package kz.baibalaeva.demo.trelloServices;

import kz.baibalaeva.demo.trelloModels.Folders;

import java.util.List;

public interface FoldersServices {
    Folders addFolders(Folders folders);
    Folders saveFolders(Folders folders);
    List<Folders> getAllFolders();
    Folders getFolders(Long id);
    void deleteFolders(Folders folders);
}
