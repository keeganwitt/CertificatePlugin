package com.github.keeganwitt.plugins.certificates.strategies;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.github.keeganwitt.plugins.certificates.shared.NoSourceException;
import com.github.keeganwitt.plugins.certificates.shared.Result;

import java.io.IOException;

public class FindFromPem extends FromFileFindingStrategy {

    @Override
    public Result find(AnActionEvent source) {
        try {
            String content = new String(this.getSource(source).contentsToByteArray());
            Result result = new Result();
            result.setCertificates(parsePEM(content));
            return result;
        } catch (IOException | IllegalArgumentException | NoSourceException e) {
            return Result.exceptionThrown(e);
        }
    }
}
