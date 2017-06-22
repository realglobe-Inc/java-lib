/*----------------------------------------------------------------------
 * Copyright 2017 realglobe Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *----------------------------------------------------------------------*/

package jp.realglobe.lib.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ShutdownHookableRunner のテスト
 */
public class ShutdownHookableRunnerTest {

    private ExecutorService executor;

    /**
     * 準備
     */
    @Before
    public void before() {
        this.executor = Executors.newCachedThreadPool();
    }

    /**
     * 後片付け
     */
    @After
    public void after() {
        this.executor.shutdownNow();
    }

    private static class NopRunner extends ShutdownHookableRunner {

        private NopRunner(final Runnable shutdownHook) {
            super(shutdownHook);
        }

        @Override
        protected void runCore() {}

    }

    private static class ErrorRunner extends ShutdownHookableRunner {

        private ErrorRunner(final Runnable shutdownHook) {
            super(shutdownHook);
        }

        @Override
        protected void runCore() {
            throw new RuntimeException();
        }

    }

    /**
     * 通常終了時の動作テスト
     * @throws Exception エラー
     */
    @Test
    public void testNormal() throws Exception {
        final AtomicBoolean shutdown = new AtomicBoolean(false);
        final Runnable runner = new NopRunner(new Runnable() {
            @Override
            public void run() {
                shutdown.set(true);
            }
        });
        final Future<?> future = this.executor.submit(runner);
        future.get();
        Assert.assertTrue(shutdown.get());
    }

    /**
     * エラー落ちの時の動作テスト
     * @throws Exception エラー
     */
    @Test
    public void testError() throws Exception {
        final AtomicBoolean shutdown = new AtomicBoolean(false);
        final Runnable runner = new ErrorRunner(new Runnable() {
            @Override
            public void run() {
                shutdown.set(true);
            }
        });
        final Future<?> future = this.executor.submit(runner);
        try {
            future.get();
        } catch (final ExecutionException e) {
            // エラー落ち
        }
        Assert.assertTrue(shutdown.get());
    }

}
