package medium;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComplFutures {

  public void test() throws Exception{
/*      CompletableFuture<Void> runResult = computeSomething()
        .thenAccept(System.out::println)
        .exceptionally(t -> {
        throw new Exception("can not get driver by email", t);
      });*/
    CompletableFuture<Void> runResultBoth = computeSomething().thenAcceptBoth(computeInteger(), (s, i)-> System.out.println(s+i));

    List<CompletableFuture<Integer>> futures =IntStream.of(1,2,3,4,5)
      .mapToObj(this::computeInteger).collect(Collectors.toList());

    CompletableFuture.allOf(futures.get(0), futures.get(1), futures.get(2));

    List<Integer> intResults = futures.stream().map(i -> {
      try {
        return i.get(1, TimeUnit.MILLISECONDS);
      } catch (InterruptedException | TimeoutException | ExecutionException e) {
        e.printStackTrace();
      }
      return 0;
    })
      .collect(Collectors.toList());



    CompletableFuture<Integer> runResultInt = computeSomething().thenApply(String::length);

    CompletableFuture<CompletableFuture<String>> runResultSomething = computeSomething().thenApply(this::computeSomething);


    CompletableFuture<Boolean> booleanResult =
      computeSomething().thenCompose(s-> computeInteger()).thenCompose(i->{
        return computeBoolean();
      });
  }

  public CompletableFuture<String> computeSomething(){
    return CompletableFuture.supplyAsync(()->"test");
  }
  public CompletableFuture<String> computeSomething(String s){
    return CompletableFuture.supplyAsync(()->"test" + s);
  }

  public CompletableFuture<Integer> computeInteger(){
    return CompletableFuture.supplyAsync(()->42);
  }
  public CompletableFuture<Integer> computeInteger(int i){
    return CompletableFuture.supplyAsync(()->42+i);
  }
  public CompletableFuture<Boolean> computeBoolean(){
    return CompletableFuture.supplyAsync(()->false);
  }


  @Test
  public void testCF()
  {
  }

}
