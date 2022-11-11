import React from 'react';
import { withTranslation } from 'react-i18next';
import { changeLanguage } from '../api/apiCalls';

const LanguageSelector = (props) => {

    const onChangeLanguage = language => {
        const { i18n } = props;
        i18n.changeLanguage(language);
        changeLanguage(language);
    }

    return (
    <div className='container'>
        <img
            src="https://flagcdn.com/h20/tr.png"
            srcset="https://flagcdn.com/h40/tr.png 2x,
                https://flagcdn.com/h60/tr.png 3x"
            width="20"
            height="20"
            alt="Turkey"
            onClick={() => onChangeLanguage('tr')}
            style ={{cursor : 'pointer'}}>
        </img>
        &nbsp;
        <img
            src="https://flagcdn.com/h20/us.png"
            srcset="https://flagcdn.com/h40/us.png 2x,
                https://flagcdn.com/h60/us.png 3x"
            width="20"    
            height="20"
            alt="United States"
            onClick={() => onChangeLanguage('en')}
            style ={{cursor : 'pointer'}}>
        </img>        
    </div>
    );
};

export default withTranslation() (LanguageSelector);