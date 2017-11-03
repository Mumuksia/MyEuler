package medium;

import java.util.concurrent.CompletableFuture;

public interface CFService {
  CompletableFuture<String> doString();
}
