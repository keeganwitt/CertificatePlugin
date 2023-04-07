package com.github.keeganwitt.plugins.certificates.strategies;

import com.github.keeganwitt.plugins.certificates.shared.NoSourceException;
import com.github.keeganwitt.plugins.certificates.shared.Result;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.io.IOException;

public class FindFromDer extends FromFileFindingStrategy {
    @Override
    public Result find(AnActionEvent source) {
        try {
            Result result = new Result();
            result.setCertificates(parsePEM(new String(this.getSource(source).contentsToByteArray())));
            return result;
        } catch (IOException | NoSourceException e) {
            return Result.exceptionThrown(e);
        }
    }
}
