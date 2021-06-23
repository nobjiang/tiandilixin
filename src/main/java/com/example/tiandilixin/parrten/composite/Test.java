package com.example.tiandilixin.parrten.composite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test {
    public static void main(String[] args) {
        EngineController engineController = new EngineController();
        String process = engineController.process("Oli09pLkdjh", "man", 29);
        log.info("测试结果:{}", process);
    }
}
