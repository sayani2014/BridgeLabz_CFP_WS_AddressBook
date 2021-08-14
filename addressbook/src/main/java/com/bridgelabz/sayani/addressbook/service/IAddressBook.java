package com.bridgelabz.sayani.addressbook.service;

import com.bridgelabz.sayani.addressbook.dto.AddressBookDTO;

import java.util.List;

public interface IAddressBook {
    AddressBookDTO addAddressDetails(AddressBookDTO addressBookDTO);

    List<AddressBookDTO> getAddressDetails();

    AddressBookDTO getAddressDetailsByID(int id);

    AddressBookDTO updateAddressDetails(int id, AddressBookDTO addressBookDTO);

    AddressBookDTO deleteAddressDetails(int id);
}
