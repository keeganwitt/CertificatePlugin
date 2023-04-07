package com.github.keeganwitt.plugins.certificates.strategies;

import com.github.keeganwitt.plugins.certificates.shared.NoSourceException;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;

public abstract class FromEditorFindingStrategy extends FindingStrategy {
    @Override
    protected Editor getSource(AnActionEvent event) throws NoSourceException {
        Editor source = event.getData(CommonDataKeys.EDITOR);
        if ( source == null ) {
            throw new NoSourceException("Event was not triggered from editor window");
        }
        return source;
    }
}
