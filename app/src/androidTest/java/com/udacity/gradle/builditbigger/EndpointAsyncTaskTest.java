package com.udacity.gradle.builditbigger;


import android.content.Context;

import android.support.test.runner.AndroidJUnit4;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    Context context;

    @Test
    public void testdoInBackground() throws Exception {

        final CountDownLatch latch = new CountDownLatch(1);

        EndpointAsyncTask testTask = new EndpointAsyncTask() {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null){
                    assertTrue(result.contains("This is funny. So laugh!"));
                    latch.countDown();
                }
            }
        };
        testTask.execute(context);
        latch.await();
    }
}