package com.example.acu1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MyCardViewModelTest {
    private lateinit var viewModel: MyCardViewModel

    @BeforeEach
    fun setUp() {
        viewModel = MyCardViewModel()
    }

    @Test
    fun `GIVEN initial view model WHEN show alert is called THEN alert lang is visible should change from False to True`() {
        assertFalse(viewModel.alertLangIsVisible.value)
        viewModel.showAlert()
        assertTrue(viewModel.alertLangIsVisible.value)
    }

    @Test
    fun `GIVEN an alert WHEN showAlert is called THEN it should throw an assertion error`() {
        viewModel.showAlert()
        assertThrows(AssertionError::class.java) {
            viewModel.showAlert()
        }
    }

    @Test
    fun `GIVEN alert visible WHEN hideAlert is called THEN alertLang should be False`() {
        viewModel.showAlert()
        assertTrue(viewModel.alertLangIsVisible.value)
        viewModel.hideAlert()
        assertFalse(viewModel.alertLangIsVisible.value)
    }

    @Test
    fun `GIVEN initial view model WHEN hideAlert is called THEN it should throw an assertion error`() {
        assertThrows(AssertionError::class.java) {
            viewModel.hideAlert()
        }
    }

    @Test
    fun `GIVEN initial view model WHEN showBottomSheet called with Linkedin THEN bottomSheetType should change from none to Linkedin`() {
        assertEquals(QrType.NONE, viewModel.bottomSheetType.value)
        viewModel.showBottomSheet(QrType.LINKEDIN)
        assertEquals(QrType.LINKEDIN, viewModel.bottomSheetType.value)
    }

    @Test
    fun `GIVEN a BottomSheet WHEN hideBottomSheet called THEN bottomSheetType should change to none`() {
        viewModel.showBottomSheet(QrType.LINKEDIN)
        viewModel.hideBottomSheet()
        assertEquals(QrType.NONE, viewModel.bottomSheetType.value)
    }

    @Test
    fun `GIVEN none bottomSheet WHEN showBottomSheetCalled THEN it should throw an exception`() {
        assertThrows(AssertionError::class.java) {
            viewModel.showBottomSheet(QrType.NONE)
        }
    }

    @Test
    fun `GIVEN none bottomSheet WHEN hideBottomSheet called THEN it should throw an exception`() {
        assertThrows(AssertionError::class.java) {
            viewModel.hideBottomSheet()
        }
    }
}