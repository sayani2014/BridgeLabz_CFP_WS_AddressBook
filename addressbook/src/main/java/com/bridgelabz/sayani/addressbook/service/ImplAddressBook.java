package com.bridgelabz.sayani.addressbook.service;

import com.bridgelabz.sayani.addressbook.dto.AddressBookDTO;
import com.bridgelabz.sayani.addressbook.entity.AddressBook;
import com.bridgelabz.sayani.addressbook.exception.AddressBookException;
import com.bridgelabz.sayani.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ImplAddressBook implements IAddressBook{

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose : Ability to insert person details in Address Book.
     *
     * @param addressBookDTO Object of AddressBookDTO which will validate user-input
     *                       and once valid, will pass it to the AddressBook entity.
     *                       Finally, the user-input details gets stored in the Database.
     *
     * @return addressBookDTO Object of AddressBookDTO.
     */

    @Override
    public AddressBookDTO addAddressDetails(AddressBookDTO addressBookDTO) {
        log.info("Inside addAddressDetails()");
        AddressBook addressBookRequest = modelMapper.map(addressBookDTO, AddressBook.class);
        addressBookRepository.save(addressBookRequest);
        return addressBookDTO;
    }

    /**
     * Purpose : Ability to fetch all person details from Address Book.
     *
     * @return List<AddressBookDTO>.
     */

    @Override
    public List<AddressBookDTO> getAddressDetails() {
        log.info("Inside getAddressDetails()");
        return addressBookRepository.findAll().stream().map(addressBook ->
                modelMapper.map(addressBook, AddressBookDTO.class))
                        .collect(Collectors.toList());
    }

    /**
     * Purpose : Ability to fetch person details from Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *           If found, it returns the person details from Address Book, else returns error message.
     *
     * @return addressBookResponse Object of AddressBookDTO.
     */

    @Override
    public AddressBookDTO getAddressDetailsByID(int id) {
        log.info("Inside getAddressDetailsByID()");
        AddressBook addressBook = findAddressBookById(id);
        AddressBookDTO addressBookResponse = modelMapper.map(addressBook, AddressBookDTO.class);
        return addressBookResponse;
    }

    /**
     * Purpose : Ability to update person details in Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *           If ID is not found, then an error message is returned.
     *
     * @param addressBookDTO If ID is found, Object of AddressBookDTO which will validate user-input
     *                       and once valid, will pass it to the AddressBook entity.
     *                       Finally, the user-input details gets stored in the Database.
     *
     * @return addressBookResponse Object of AddressBookDTO.
     */

    @Override
    public AddressBookDTO updateAddressDetails(int id, AddressBookDTO addressBookDTO) {
        log.info("Inside updateAddressDetails()");
        AddressBookDTO addressBookResponse = null;
        if (id > 0) {
            AddressBook addressBookDetails = findAddressBookById(id);
            String[] ignoreFields = {"id", "name", "createdDate"};
            BeanUtils.copyProperties(addressBookDTO, addressBookDetails, ignoreFields);
            addressBookRepository.save(addressBookDetails);
            addressBookResponse = modelMapper.map(addressBookDetails, AddressBookDTO.class);
        }
        return addressBookResponse;
    }

    /**
     * Purpose : Ability to delete person details from Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *           If found, it deletes the person details from Address Book, else returns error message.
     *
     * @return addressBookResponse Object of AddressBookDTO.
     */

    @Override
    public AddressBookDTO deleteAddressDetails(int id) {
        log.info("Inside deleteAddressDetails()");
        AddressBookDTO addressBookResponse = null;
        if (id > 0) {
            AddressBook addressBook = findAddressBookById(id);
            addressBookRepository.delete(addressBook);
            addressBookResponse = modelMapper.map(addressBook, AddressBookDTO.class);
        }
        return addressBookResponse;
    }

    /**
     * Purpose : Ability to find ID from Address Book database.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *
     * @return If found, object of AddressBook, else return error message.
     */

    private AddressBook findAddressBookById(int id) {
        log.info("Inside findAddressBookById()");
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Unable to find any address book detail!"));
    }
}
