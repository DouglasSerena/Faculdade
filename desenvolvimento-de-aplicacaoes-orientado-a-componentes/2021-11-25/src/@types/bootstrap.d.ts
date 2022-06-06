declare namespace bootstrap {
  /**
   * | Event type      | Description                                                                   |
   * | --------------- | ----------------------------------------------------------------------------- | 
   * | show.bs.toast	 | This event fires immediately when the show instance method is called.         |
   * | shown.bs.toast	 | This event is fired when the toast has been made visible to the user.         |
   * | hide.bs.toast	 | This event is fired immediately when the hide instance method has been called.|
   * | hidden.bs.toast | This event is fired when the toast has finished being hidden from the user.   |
   */
  class Toast {
    constructor(
      element: HTMLElement,
      options?: {
        keyboard?: boolean;
        backdrop?: "static" | boolean;
        focus?: boolean;
      }
    ): void;

    /** @description Static method which allows you to get the scrollspy instance associated with a DOM element */
    static getInstance(element: HTMLElement): Toast;
    /** @description Static method which allows you to get the scrollspy instance associated with a DOM element, or create a new one in case it wasn’t initialised */
    static getOrCreateInstance(element: HTMLElement): Toast;

    /** @description Reveals an element’s toast. Returns to the caller before the toast has actually been shown (i.e. before the shown.bs.toast event occurs). You have to manually call this method, instead your toast won’t show. */
    show(): void;
    /** @description Hides an element’s toast. Returns to the caller before the toast has actually been hidden (i.e. before the hidden.bs.toast event occurs). You have to manually call this method if you made autohide to false. */
    hide(): void;
    /** @description Hides an element’s toast. Your toast will remain on the DOM but won’t show anymore. */
    dispose(): void;
  }
  class Modal {
    constructor(
      element: HTMLElement,
      options?: {
        keyboard?: boolean;
        backdrop?: "static" | boolean;
        focus?: boolean;
      }
    ): void;

    /** Manually toggles a modal. Returns to the caller before the modal has actually been shown or hidden (i.e. before the shown.bs.modal or hidden.bs.modal event occurs). */
    toggle(): void;

    /** @description Manually opens a modal. Returns to the caller before the modal has actually been shown (i.e. before the shown.bs.modal event occurs). */
    show(element: HTMLElement): void;
    show(): void;

    /** @description Manually hides a modal. Returns to the caller before the modal has actually been hidden (i.e. before the hidden.bs.modal event occurs). */
    hide(): void;

    /** @description Manually readjust the modal’s position if the height of a modal changes while it is open (i.e. in case a scrollbar appears). */
    handleUpdate(): void;

    /** @description Destroys an element’s modal. (Removes stored data on the DOM element) */
    dispose(): void;
  }
}
