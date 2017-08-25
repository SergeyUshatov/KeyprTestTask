package someLogic;

import model.*;
import testData.TestData;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.TemporalQueries.localTime;
import static utils.Utils.getSHA1Checksum;

public class GHHelper {
    public static Commit prepareCommit(String filePath, GHCommit parent) throws Exception {
        List<String> parents = new ArrayList<>();
        parents.add(parent.getSha());
        Commit commit = new Commit()
                .setMessage("commit for test file " + Utils.localTime())
                .setTreeSha(prepareTree(filePath))
                .setParents(parents);
        return commit;
    }

    private static String prepareTree(String filePath) throws Exception {
        Tree tree = new Tree()
                .setPath(filePath)
                .setMode(GHFileTypes.FILE_BLOB.getValue())
                .setType(GHFileTypes.FILE_BLOB.getType())
                .setSha(getSHA1Checksum(filePath));
//        List<Tree> trees = new ArrayList<>();
//        trees.add(tree);
//        GHTree ghTree = new GHTree()
//                .setTree(trees)
//                .setBase_tree(baseSha);
        return tree.getSha();
    }

    public static Commit prepareGHCommit() throws Exception {
        String file = TestData.get(TestData.testFile);
        GHCommit[] commits = Rest.getTestCommits();
        Commit commit = prepareCommit(file, commits[0]);
//        List<Parent> parents = new ArrayList<>();
//        parents.add(new Parent(commits[0].getSha()));
//        GHCommit ghCommit = new GHCommit()
//                .setCommit(commit)
//                .setParents(parents);
        return commit;
    }
}
