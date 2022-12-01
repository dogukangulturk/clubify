import React, { Component } from 'react';
import logo from '../assets/clubify.png';
import { Link } from 'react-router-dom';
import { withTranslation } from 'react-i18next';

class TopBar extends Component {
    render() {
        const { t } = this.props;
        return (
            <div className='shadow-sm bg-dark mb-2'>
                <nav className="navbar navbar-light container navbar-expand">
                    <Link className="navbar-brand" to="/">
                        <img src={logo} width="100" alt="Clubify Logo" /> 
                    </Link>

                    <ul className="navbar-nav ms-auto">
                        <li>
                            <Link className='nav-link' to="/login" style={{color: 'white'}}>
                                {t('Login')}
                            </Link>
                        </li>
                        <li>
                            <Link className='nav-link' to="/signup" style={{color: 'white'}}>
                                {t('Sign Up')}
                            </Link>
                        </li>
                    </ul>

                </nav>
            </div>
        );
    }
}

export default withTranslation()(TopBar);