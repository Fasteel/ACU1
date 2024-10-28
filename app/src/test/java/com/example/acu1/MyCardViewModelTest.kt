package com.example.acu1

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@Suppress("FunctionName")
class MyCardViewModelTest {
    private lateinit var viewModel: MyCardViewModel

    @Before
    fun setUp() {
        viewModel = MyCardViewModel()
    }

    @Test
    fun givenInitialViewModel_whenShowAlertIsCalled_thenAlertLangIsVisibleShouldChangeFromFalseToTrue() {
        assertFalse(viewModel.alertLangIsVisible.value)
        viewModel.showAlert()
        assertTrue(viewModel.alertLangIsVisible.value)
    }

    @Test(expected = AssertionError::class)
    fun givenAnAlert_whenShowAlertIsCalled_thenItShouldThrowAnAssertionError() {
        viewModel.showAlert()
        viewModel.showAlert()
    }

    @Test
    fun givenAlertVisible_whenHideAlertIsCalled_thenAlertLangShouldBeFalse() {
        viewModel.showAlert()
        assertTrue(viewModel.alertLangIsVisible.value)
        viewModel.hideAlert()
        assertFalse(viewModel.alertLangIsVisible.value)
    }

    @Test(expected = AssertionError::class)
    fun givenInitialViewModel_whenHideAlertIsCalled_thenItShouldThrowAnAssertionError() {
        viewModel.hideAlert()
    }

    @Test
    fun givenInitialViewModel_whenShowBottomSheetCalledWithLinkedin_thenBottomSheetTypeShouldChangeFromNoneToLinkedin() {
        assertEquals(QrType.NONE, viewModel.bottomSheetType.value)
        viewModel.showBottomSheet(QrType.LINKEDIN)
        assertEquals(QrType.LINKEDIN, viewModel.bottomSheetType.value)
    }

    @Test
    fun givenABottomSheet_whenHideBottomSheetCalled_thenBottomSheetTypeShouldChangeToNone() {
        viewModel.showBottomSheet(QrType.LINKEDIN)
        viewModel.hideBottomSheet()
        assertEquals(QrType.NONE, viewModel.bottomSheetType.value)
    }

    @Test(expected = AssertionError::class)
    fun givenNoneBottomSheet_whenShowBottomSheetCalled_thenItShouldThrowAnException() {
        viewModel.showBottomSheet(QrType.NONE)
    }

    @Test(expected = AssertionError::class)
    fun givenNoneBottomSheet_whenHideBottomSheetCalled_thenItShouldThrowAnException() {
        viewModel.hideBottomSheet()
    }
}