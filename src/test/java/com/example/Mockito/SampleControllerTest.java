package com.example.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SampleControllerTest {

    @Mock
    MessageService messageService;

    @Spy
    @InjectMocks
    SampleController sampleController = new SampleController();

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testcase001() {
        int i = 1;  // 直接設定
        doReturn("モック化できたよ").when(messageService).getMessage(i);

        String expected = "モック化できたよ";
        String actual = sampleController.sample1(i);
        
        verify(messageService, times(1)).getMessage(i);

        assertEquals(expected, actual);
    }

    @Test
    public void testcase002() throws Exception {
        int i = 1;  // 直接設定
        String margeMessage = "marge";  // 直接設定

        doReturn("モック化できたよ").when(messageService).getMessage(i);
        doReturn("モック化できたよ").when(messageService).margeMessage("モック化できたよ", margeMessage);
        doReturn("spyオブジェクトモック化").when(sampleController).messageTrim(anyString());

        String expected = "spyオブジェクトモック化";
        String actual = sampleController.sample2(i, margeMessage);

        verify(messageService, times(1)).getMessage(anyInt());
        verify(messageService, times(1)).margeMessage(anyString(), anyString());
        verify(sampleController, times(1)).messageTrim(anyString());

        assertEquals(expected, actual);
    }
}
