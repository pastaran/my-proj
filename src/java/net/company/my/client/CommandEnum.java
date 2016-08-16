package net.company.my.client;

import net.company.my.command.ActionCommand;
import net.company.my.command.AddAuthorCommand;
import net.company.my.command.DeleteAuthorCommand;
import net.company.my.command.GiveBookCommand;
import net.company.my.command.GoUpdateAuthorCommand;
import net.company.my.command.LoginCommand;
import net.company.my.command.LogoutCommand;
import net.company.my.command.OrderBookCommand;
import net.company.my.command.RegisterCommand;
import net.company.my.command.ReturnBookCommand;
import net.company.my.command.SearchBooksCommand;
import net.company.my.command.ShowAuthorsCommand;
import net.company.my.command.ShowBooksCommand;
import net.company.my.command.ShowOrdersCommand;
import net.company.my.command.UpdateAuthorCommand;

/**
 *
 * @author Kostya
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SHOWBOOKS {
        {
            this.command = new ShowBooksCommand();
        }
    },
    SHOWAUTHORS {
        {
            this.command = new ShowAuthorsCommand();
        }
    },
    SEARCHBOOKS {
        {
            this.command = new SearchBooksCommand();
        }
    },
    ORDERBOOK {
        {
            this.command = new OrderBookCommand();
        }
    },
    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    SHOWORDERS {
        {
            this.command = new ShowOrdersCommand();
        }
    },
    GIVEBOOK {
        {
            this.command = new GiveBookCommand();
        }
    },
    RETURNBOOK {
        {
            this.command = new ReturnBookCommand();
        }
    },
    ADDAUTHOR {
        {
            this.command = new AddAuthorCommand();
        }
    },
    UPDATEAUTHOR {
        {
            this.command = new UpdateAuthorCommand();
        }
   },
    GOUPDATEAUTHOR {
        {
            this.command = new GoUpdateAuthorCommand();
        }
   },
    DELETEAUTHOR {
        {
            this.command = new DeleteAuthorCommand();
        }
    };
    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
